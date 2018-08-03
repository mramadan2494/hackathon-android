class SchmainsController < ApplicationController
  before_action :set_schmain, only: [:show, :update, :destroy]

  # GET /schmains
  def index
    @schmains = Schmain.all

    render json: @schmains
  end

  # GET /schmains/1
  def show
    render json: @schmain
  end

  # POST /schmains
  def create
    @schmain = Schmain.new(schmain_params)

    if @schmain.save
      render json: @schmain, status: :created, location: @schmain
    else
      render json: @schmain.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /schmains/1
  def update
    if @schmain.update(schmain_params)
      render json: @schmain
    else
      render json: @schmain.errors, status: :unprocessable_entity
    end
  end

  # DELETE /schmains/1
  def destroy
    @schmain.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_schmain
      @schmain = Schmain.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def schmain_params
      params.require(:schmain).permit(:schName)
    end
end
