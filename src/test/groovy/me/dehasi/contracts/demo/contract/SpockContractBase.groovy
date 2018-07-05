package me.dehasi.contracts.demo.contract

import io.restassured.RestAssured
import spock.lang.Specification

class SpockContractBase extends Specification {
    String host = "http://localhost:8080/"
    def setup() {
        RestAssured.baseURI = host
    }
}
