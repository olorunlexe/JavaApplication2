package com.mycompany.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserPin.class)
public abstract class UserPin_ {

	public static volatile SingularAttribute<UserPin, String> userpinStatus;
	public static volatile SingularAttribute<UserPin, Integer> id;
	public static volatile SingularAttribute<UserPin, PinTbl> pinId;
	public static volatile SingularAttribute<UserPin, User> userId;

}

