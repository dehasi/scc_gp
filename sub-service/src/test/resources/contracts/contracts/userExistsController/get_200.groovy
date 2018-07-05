package contracts.userExistsController

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath '/exists/2'
    }
    response {
        status 200
    }
}