import { assert } from 'chai'
import { add } from '../logic.js'
import { describe} from 'mocha'

describe("test af add funktion", () => {
    it("test 1 af add", () => {
        let result = add(2, 3)
        assert.equal(result, 5)
    })
})