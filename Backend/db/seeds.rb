# frozen_string_literal: true

# # frozen_string_literal: true
#
# # This file should contain all the record creation needed to seed the database with its default values.
# # The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
# #
# # Examples:
# #
# #   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
# #   Character.create(name: 'Luke', movie: movies.first)
#
require 'csv'
file_path = Rails.root.join('db','data.csv')
puts file_path
CSV.foreach(file_path, headers: true) do |row|
  Location.create!(row.to_hash)
end
#
# require 'roo'
# file_path = Rails.root.join('db', 'a2.xlsx')
#
# xlsx = Roo::Excelx.new(file_path)
# xlsx.each_row_streaming(offset: 1) do |row|
#   puts row.inspect
# end
#
#
# end
