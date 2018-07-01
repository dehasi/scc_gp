package contracts.userExistsController

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/exists/43'
    }
    response {
        status 404
    }
}