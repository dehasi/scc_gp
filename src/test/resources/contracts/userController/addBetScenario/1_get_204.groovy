package userController.addBetScenario

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/bets/1'
    }
    response {
        status 204
    }
}