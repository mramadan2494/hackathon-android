class CreateUsers < ActiveRecord::Migration[5.2]
  def change
    create_table :users do |t|
      t.string :userId
      t.string :userName
      t.integer :phone , limit: 8
      t.string :password

      t.timestamps
    end
  end
end
