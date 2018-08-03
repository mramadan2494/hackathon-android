class CreateCompanies < ActiveRecord::Migration[5.2]
  def change
    create_table :companies do |t|
      t.bigint :companyNo
      t.string :companyName
      t.float :menalat
      t.float :menalong
      t.float :arfalat
      t.float :menalong
      t.float :mozdalat
      t.float :mozdalong
      t.timestamps
    end
  end
end
