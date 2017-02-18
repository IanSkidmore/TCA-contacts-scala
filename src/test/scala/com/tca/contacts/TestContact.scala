package com.tca.contacts

import org.scalatest.{FunSpec, Matchers}

/**
  * Created by Ian Skidmore on 18/02/2017.
  */
class TestPerson extends FunSpec with Matchers {
  val p: Person = Person("Skidmore", "Ian", "John")
  describe("a Person") {
    it("can compose a person's full name") {
      p.FullName should be("Ian John Skidmore")

    }
  }
}

class TestAddress extends FunSpec with Matchers{
  val addr: Address = Address("5","","2","Maitland Flats","Barrack Lane","The Park","Nottingham","","NG7 1AN")
  describe ("an Address"){
    it("can compose a mailing address"){
      addr.Streetline should be ("5 Maitland Flats 2 Barrack Lane")
    }
  }
}

class TestContact extends FunSpec with Matchers{
  val p: Person = Person("Skidmore", "Ian")
  val addr: Address = Address("5","","2","Maitland Flats","Barrack Lane","The Park","Nottingham","","NG7 1AN")
  val org: Organisation = Organisation("Thorneycreek Consulting Ltd")
  describe("a Contact"){
    it("can format an address label"){
      val c1 = Contact(p)
      c1.Label should be ("Ian Skidmore")

      val c2 = Contact(p,None,Some(org))
      c2.Label should be ("Ian Skidmore, Thorneycreek Consulting Ltd")

      val c3 = Contact(p,Some(addr))
      c3.Label should be ("Ian Skidmore, 5 Maitland Flats 2 Barrack Lane")

      val c4 = Contact(p, Some(addr), Some(org))
      c4.Label should be ("Ian Skidmore, Thorneycreek Consulting Ltd, 5 Maitland Flats 2 Barrack Lane")
    }
  }
}

