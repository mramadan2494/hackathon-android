class CreateReadings < ActiveRecord::Migration[5.2]
  def change
    create_table :readings do |t|
      t.string :userId
      t.datetime :rDateTime
      t.float :lat
      t.float :long

      t.timestamps
    end
  end
end
