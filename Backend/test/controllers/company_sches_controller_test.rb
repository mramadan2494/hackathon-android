require 'test_helper'

class CompanySchesControllerTest < ActionDispatch::IntegrationTest
  setup do
    @company_sch = company_sches(:one)
  end

  test "should get index" do
    get company_sches_url, as: :json
    assert_response :success
  end

  test "should create company_sch" do
    assert_difference('CompanySch.count') do
      post company_sches_url, params: { company_sch: { companyNo: @company_sch.companyNo, schID: @company_sch.schID, sdate: @company_sch.sdate, status: @company_sch.status, stime: @company_sch.stime } }, as: :json
    end

    assert_response 201
  end

  test "should show company_sch" do
    get company_sch_url(@company_sch), as: :json
    assert_response :success
  end

  test "should update company_sch" do
    patch company_sch_url(@company_sch), params: { company_sch: { companyNo: @company_sch.companyNo, schID: @company_sch.schID, sdate: @company_sch.sdate, status: @company_sch.status, stime: @company_sch.stime } }, as: :json
    assert_response 200
  end

  test "should destroy company_sch" do
    assert_difference('CompanySch.count', -1) do
      delete company_sch_url(@company_sch), as: :json
    end

    assert_response 204
  end
end
