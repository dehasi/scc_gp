package userController.addBetScenario

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/bets/1'
    }
    response {
        status 200

        body('''
          {
            "sport":"football",
            "amount": 10
          }
          '''
        )
    }
}