class HajsController < ApplicationController
  before_action :set_haj, only: [:show, :update, :destroy]

  # GET /hajs
  def index
    @hajs = Haj.all

    render json: @hajs
  end

  # GET /hajs/1
  def show
    render json: @haj
  end

  # POST /hajs
  def create
    @haj = Haj.new(haj_params)

    if @haj.save
      render json: @haj, status: :created, location: @haj
    else
      render json: @haj.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /hajs/1
  def update
    if @haj.update(haj_params)
      render json: @haj
    else
      render json: @haj.errors, status: :unprocessable_entity
    end
  end

  # DELETE /hajs/1
  def destroy
    @haj.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_haj
      @haj = Haj.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def haj_params
      params.require(:haj).permit(:hajjId, :groupNo, :companyNo)
    end
end
