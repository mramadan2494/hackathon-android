class AddColumn < ActiveRecord::Migration[5.2]
  def change
    add_column :companies ,:arfalong ,:float
  end
end
