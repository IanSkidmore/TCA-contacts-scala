package com.tca.contacts

/**
  * Created by Ian Skidmore on 18/02/2017.
  */
case class Person(Surname: String, FirstName: String, MiddleName:String = ""){
  val Forenames: String = (FirstName + " " + MiddleName).trim
  val FullName: String = Forenames + " " + Surname
}

case class Address(FlatNumber: String = "", FlatName: String = "", HouseNumber: String = "", HouseName: String = "",
                   StreetName: String, District: String = "", Town: String, County: String = "", Postcode: String = ""){
  val Flat = (FlatNumber + " " + FlatName).trim
  val Premise: String = (Flat + " " + HouseName + " " + HouseNumber).trim
  val Streetline = Premise + " " + StreetName

}
case class Organisation(Name: String){}

case class Contact (Name: Person, PostalAddress:Option[Address] = None, Organisation:Option[Organisation] = None){
  val AddressLabel: String = PostalAddress match
  {
    case None => ""
    case Some(a) => ", " + PostalAddress.get.Streetline
  }

  val OrgName: String = Organisation match
  {
    case None => ""
    case Some(a) => ", " + Organisation.get.Name
  }

  val Label: String = {
    val sb = StringBuilder.newBuilder
    sb.append(Name.FullName)
    sb.append(OrgName)
    sb.append(AddressLabel)
    sb.toString()
  }
}
