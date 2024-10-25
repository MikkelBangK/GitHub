import { describe, it } from "mocha";
import { add } from "../logik.js";
import { assert } from "chai";

describe("When add numbers", () => {
  it("test 1 på add", () => {
    let result = add(2, 3);
    assert.equal(result, 5);
  });
  it("test 2 på add", () => {
    let result = add(4, 5);
    assert.notEqual(result, 10);
  });
});
