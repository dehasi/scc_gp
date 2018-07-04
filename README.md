[![Build Status](https://travis-ci.org/dehasi/scc_gp.svg?branch=master)](https://travis-ci.org/dehasi/scc_gp)

# Spring Cloud Contract Demo

### problem

### mock and test
`$ gradle :generateContractTests`

`$ gradle :generateClientStubs`

`$ gradle :test`

### integrate with internal service

Add  `@AutoConfigureStubRunner`

`$ gradle : publishStubsPublicationToMavenLocal`

### integrate with external service

`$ gradle : publishStubsPublicationToMavenLocal`

`baseClassMappings`

### regression tests