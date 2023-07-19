import { assert } from "chai"
import isPrime from "../src/numbers.js"

let n1=12;
let n2=7;


describe('test cases for primeNubers', () => {

    it('should return true if prime', () => {
        assert.equal(isPrime(n2),true)
    })

    it('should return false if not prime', () => {
        assert.equal(isPrime(n1), false)
    })
})
