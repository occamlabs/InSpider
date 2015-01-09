package nl.ipo.cds.domain;

import javax.validation.Valid;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class Gebruiker {
	
	@Valid
	private final LdapGebruiker ldapGebruiker;
	
	@Valid
	private final DbGebruiker dbGebruiker;
	
	public Gebruiker () {
		this (new LdapGebruiker (), new DbGebruiker ());
	}
	
	public Gebruiker (final LdapGebruiker ldapGebruiker, final DbGebruiker dbGebruiker) {
		if (ldapGebruiker == null) {
			throw new NullPointerException ("ldapGebruiker cannot be null");
		}
		if (dbGebruiker == null) {
			throw new NullPointerException ("dbGebruiker cannot be null");
		}
		
		this.ldapGebruiker = ldapGebruiker;
		this.dbGebruiker = dbGebruiker;
	}

	public LdapGebruiker getLdapGebruiker () {
		return ldapGebruiker;
	}

	public DbGebruiker getDbGebruiker () {
		return dbGebruiker;
	}
	
	/**
	 * Returns the username of this user. The username also corresponds with the 'uid' attribute in LDAP.
	 * 
	 * @return The username.
	 */
	public String getGebruikersnaam () {
		return ldapGebruiker.getGebruikersnaam ();
	}
	
	/**
	 * Sets the username of this user. The username corresponds with the 'uid' attribute in LDAP.
	 * 
	 * @param gebruikersnaam
	 */
	public void setGebruikersnaam (final String gebruikersnaam) {
		ldapGebruiker.setGebruikersnaam (gebruikersnaam);
		dbGebruiker.setGebruikersnaam (gebruikersnaam);
	}
	
	/**
	 * Returns the e-mail address of this user.
	 *  
	 * @return This user's e-mail address
	 */
	public String getEmail () {
		return ldapGebruiker.getEmail ();
	}
	
	/**
	 * Sets the e-mail address of this user.
	 * 
	 * @param email The user's new e-mail address.
	 */
	public void setEmail (final String email) {
		ldapGebruiker.setEmail (email);
	}
	
	/**
	 * Returns the optional mobile phone number of this user, or null if no number is set. Phone numbers must be specified
	 * in ITU format.
	 * 
	 * @return This users mobile phone number in ITU format, or null.
	 */
	public String getMobile () {
		return ldapGebruiker.getMobile ();
	}
	
	/**
	 * Sets the optional mobile phone number of this user, or null if no number is set. Phone numbers must be specified
	 * in ITU format.
	 * 
	 * @param mobile This user's mobile phone number in ITU format, or null.
	 */
	public void setMobile (final String mobile) {
		ldapGebruiker.setMobile (mobile);
	}
	
	/**
	 * Returns the SHA hashed password for this user.
	 * 
	 * @return The password hash as a base64 encoded string.
	 */
	public String getWachtwoordHash () {
		return ldapGebruiker.getWachtwoordHash ();
	}
	
	/**
	 * Sets the SHA hashed password for this user.
	 * 
	 * @param wachtwoordHash as a base64 encoded string.
	 */
	public void setWachtwoordHash (final String wachtwoordHash) {
		ldapGebruiker.setWachtwoordHash (wachtwoordHash);
	}
	
	/**
	 * Sets the password for this user. The password is hashed, base64 encoded and stored
	 * using setWachtwoordHash
	 * 
	 * @param wachtwoord
	 */
	public void setWachtwoord (final String wachtwoord) {
		ldapGebruiker.setWachtwoord (wachtwoord);
	}
	
	@Override
	public int hashCode () {
		return new HashCodeBuilder ().
			append (getGebruikersnaam ()).
			toHashCode ();
	}

	@Override
	public boolean equals (final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (! (obj instanceof Gebruiker)) {
			return false;
		}
		
		final Gebruiker other = (Gebruiker) obj;

		return new EqualsBuilder ().
			append (getGebruikersnaam (), other.getGebruikersnaam ()).
			isEquals ();

	}	
}
