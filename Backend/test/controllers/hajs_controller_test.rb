require 'test_helper'

class HajsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @haj = hajs(:one)
  end

  test "should get index" do
    get hajs_url, as: :json
    assert_response :success
  end

  test "should create haj" do
    assert_difference('Haj.count') do
      post hajs_url, params: { haj: { companyNo: @haj.companyNo, groupNo: @haj.groupNo, hajjId: @haj.hajjId } }, as: :json
    end

    assert_response 201
  end

  test "should show haj" do
    get haj_url(@haj), as: :json
    assert_response :success
  end

  test "should update haj" do
    patch haj_url(@haj), params: { haj: { companyNo: @haj.companyNo, groupNo: @haj.groupNo, hajjId: @haj.hajjId } }, as: :json
    assert_response 200
  end

  test "should destroy haj" do
    assert_difference('Haj.count', -1) do
      delete haj_url(@haj), as: :json
    end

    assert_response 204
  end
end
