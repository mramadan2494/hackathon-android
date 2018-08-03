class CreateCompanySches < ActiveRecord::Migration[5.2]
  def change
    create_table :company_sches do |t|
      t.bigint :schID
      t.bigint :companyNo
      t.date :sdate
      t.time :stime
      t.string :status

      t.timestamps
    end
  end
end
