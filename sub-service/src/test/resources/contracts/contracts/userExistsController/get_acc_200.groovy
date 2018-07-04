package contracts.userExistsController

org.springframework.cloud.contract.spec.Contract.make {
//    ignored()
    request {
        method 'GET'
        urlPath '/exists/11'
    }
    response {
        status 200
    }
}