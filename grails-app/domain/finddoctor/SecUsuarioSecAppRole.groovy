package finddoctor

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class SecUsuarioSecAppRole implements Serializable {

	private static final long serialVersionUID = 1

	SecUsuario secUsuario
	SecAppRole secAppRole

	@Override
	boolean equals(other) {
		if (other instanceof SecUsuarioSecAppRole) {
			other.secUsuarioId == secUsuario?.id && other.secAppRoleId == secAppRole?.id
		}
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (secUsuario) builder.append(secUsuario.id)
		if (secAppRole) builder.append(secAppRole.id)
		builder.toHashCode()
	}

	static SecUsuarioSecAppRole get(long secUsuarioId, long secAppRoleId) {
		criteriaFor(secUsuarioId, secAppRoleId).get()
	}

	static boolean exists(long secUsuarioId, long secAppRoleId) {
		criteriaFor(secUsuarioId, secAppRoleId).count()
	}

	private static DetachedCriteria criteriaFor(long secUsuarioId, long secAppRoleId) {
		SecUsuarioSecAppRole.where {
			secUsuario == SecUsuario.load(secUsuarioId) &&
			secAppRole == SecAppRole.load(secAppRoleId)
		}
	}

	static SecUsuarioSecAppRole create(SecUsuario secUsuario, SecAppRole secAppRole) {
		def instance = new SecUsuarioSecAppRole(secUsuario: secUsuario, secAppRole: secAppRole)
		instance.save()
		instance
	}

	static boolean remove(SecUsuario u, SecAppRole r) {
		if (u != null && r != null) {
			SecUsuarioSecAppRole.where { secUsuario == u && secAppRole == r }.deleteAll()
		}
	}

	static int removeAll(SecUsuario u) {
		u == null ? 0 : SecUsuarioSecAppRole.where { secUsuario == u }.deleteAll()
	}

	static int removeAll(SecAppRole r) {
		r == null ? 0 : SecUsuarioSecAppRole.where { secAppRole == r }.deleteAll()
	}

	static constraints = {
		secAppRole validator: { SecAppRole r, SecUsuarioSecAppRole ur ->
			if (ur.secUsuario?.id) {
				SecUsuarioSecAppRole.withNewSession {
					if (SecUsuarioSecAppRole.exists(ur.secUsuario.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['secUsuario', 'secAppRole']
		version false
	}
}
