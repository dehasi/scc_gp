package userController

org.springframework.cloud.contract.spec.Contract.make {
    description('''
given: Best url
when: User requests bets
then: Server returns 404 if the user has no bets
''')
    request {
        method 'GET'
        urlPath '/bets/42'
    }
    response {
        status 404
    }
}