class CreateSchmains < ActiveRecord::Migration[5.2]
  def change
    create_table :schmains do |t|
      t.string :schName

      t.timestamps
    end
  end
end
