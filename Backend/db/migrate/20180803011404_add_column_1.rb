class AddColumn1 < ActiveRecord::Migration[5.2]
  def change
    add_column :hajs ,:hajName,:string
  end
end
