class CompanySchesController < ApplicationController
  before_action :set_company_sch, only: [:show, :update, :destroy]

  # GET /company_sches
  def index
    @company_sches = CompanySch.all

    render json: @company_sches
  end

  # GET /company_sches/1
  def show
    render json: @company_sch
  end

  # POST /company_sches
  def create
    @company_sch = CompanySch.new(company_sch_params)

    if @company_sch.save
      render json: @company_sch, status: :created, location: @company_sch
    else
      render json: @company_sch.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /company_sches/1
  def update
    if @company_sch.update(company_sch_params)
      render json: @company_sch
    else
      render json: @company_sch.errors, status: :unprocessable_entity
    end
  end

  # DELETE /company_sches/1
  def destroy
    @company_sch.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_company_sch
      @company_sch = CompanySch.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def company_sch_params
      params.require(:company_sch).permit(:schID, :companyNo, :sdate, :stime, :status)
    end
end
