require 'test_helper'

class SchmainsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @schmain = schmains(:one)
  end

  test "should get index" do
    get schmains_url, as: :json
    assert_response :success
  end

  test "should create schmain" do
    assert_difference('Schmain.count') do
      post schmains_url, params: { schmain: { schName: @schmain.schName } }, as: :json
    end

    assert_response 201
  end

  test "should show schmain" do
    get schmain_url(@schmain), as: :json
    assert_response :success
  end

  test "should update schmain" do
    patch schmain_url(@schmain), params: { schmain: { schName: @schmain.schName } }, as: :json
    assert_response 200
  end

  test "should destroy schmain" do
    assert_difference('Schmain.count', -1) do
      delete schmain_url(@schmain), as: :json
    end

    assert_response 204
  end
end
