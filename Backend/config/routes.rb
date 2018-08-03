Rails.application.routes.draw do
  resources :locations
  resources :readings
  resources :company_sches
  resources :schmains
  resources :companies
  resources :hajs
  resources :users
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
