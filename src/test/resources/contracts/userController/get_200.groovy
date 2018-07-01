package userController

org.springframework.cloud.contract.spec.Contract.make {
    description('''
given: Best url
when: User requests bets
then: Server returns 200 and bets in the body
''')
    request {
        method 'GET'
        urlPath '/bets/2'
    }
    response {
        status 200

        body('''
          {
            "sport":"football",
            "amount": 1
          }
          '''
        )
    }
}