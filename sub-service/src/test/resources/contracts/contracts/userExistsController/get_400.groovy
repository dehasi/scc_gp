package contracts.userExistsController

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath '/exists/wrong_name'
    }
    response {
        status 400
    }
}