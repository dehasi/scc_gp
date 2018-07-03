package contracts.userExistsController

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/exists/1'
    }
    response {
        status 200
    }
}