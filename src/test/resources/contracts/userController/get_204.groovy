package userController

org.springframework.cloud.contract.spec.Contract.make {
    description('''
given: Best url
when: User requests bets
then: Server returns NoContent if the user has no bets
''')
    request {
        method 'GET'
        urlPath '/bets/1'
    }
    response {
        status 204
    }
}