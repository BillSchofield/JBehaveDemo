package org.jbehave.demo.builders;

import org.jbehave.demo.domain.Passenger;

import static org.jbehave.demo.domain.Passenger.Gender;

/**
 * Created by ThoughtWorker on 4/1/14.
 */
public class PassengerBuilder {
    private String name = "Able Baker";
    private String loyalty = "1234567";
    private Gender gender = Gender.Male;


    public Passenger build() {
        return new Passenger(name, loyalty, gender);
    }

    public PassengerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PassengerBuilder withLoyaltyNumber(String loyalty) {
        this.loyalty = loyalty;
        return this;
    }
}
