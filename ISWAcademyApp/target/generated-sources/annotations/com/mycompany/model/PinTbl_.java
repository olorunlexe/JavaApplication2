package com.mycompany.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PinTbl.class)
public abstract class PinTbl_ {

	public static volatile SingularAttribute<PinTbl, Date> pinExpiryDate;
	public static volatile CollectionAttribute<PinTbl, UserPin> userPinCollection;
	public static volatile SingularAttribute<PinTbl, String> pin;
	public static volatile SingularAttribute<PinTbl, Integer> id;
	public static volatile SingularAttribute<PinTbl, String> pinStatus;

}

