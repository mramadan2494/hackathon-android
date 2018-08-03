# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2018_08_03_011404) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "companies", force: :cascade do |t|
    t.bigint "companyNo"
    t.string "companyName"
    t.float "menalat"
    t.float "menalong"
    t.float "arfalat"
    t.float "mozdalat"
    t.float "mozdalong"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.float "arfalong"
  end

  create_table "company_sches", force: :cascade do |t|
    t.bigint "schID"
    t.bigint "companyNo"
    t.date "sdate"
    t.time "stime"
    t.string "status"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "hajs", force: :cascade do |t|
    t.bigint "hajjId"
    t.bigint "groupNo"
    t.bigint "companyNo"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "hajName"
  end

  create_table "locations", force: :cascade do |t|
    t.string "name"
    t.float "location"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "readings", force: :cascade do |t|
    t.string "userId"
    t.datetime "rDateTime"
    t.float "lat"
    t.float "long"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "schmains", force: :cascade do |t|
    t.string "schName"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "users", force: :cascade do |t|
    t.string "userId"
    t.string "userName"
    t.bigint "phone"
    t.string "password"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

end
