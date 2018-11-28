package com.mycompany.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile CollectionAttribute<User, UserPin> userPinCollection;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Date> dateCreated;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, String> userId;

}

