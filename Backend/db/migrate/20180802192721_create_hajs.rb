class CreateHajs < ActiveRecord::Migration[5.2]
  def change
    create_table :hajs do |t|
      t.bigint :hajjId
      t.bigint :groupNo
      t.bigint :companyNo

      t.timestamps
    end
  end
end
