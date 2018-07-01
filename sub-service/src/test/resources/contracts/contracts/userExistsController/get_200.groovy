package contracts.userExistsController

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/exists/2'
    }
    response {
        status 200
    }
}