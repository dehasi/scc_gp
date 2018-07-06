package userController.addBetScenario

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        urlPath '/bets/1'
        headers {
            header("Content-Type", "application/json")
        }
        body('''
          {
            "sport":"football",
            "amount": 10
          }
          '''
        )
    }
    response {
        status 200
    }
}