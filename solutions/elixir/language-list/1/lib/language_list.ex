defmodule LanguageList do
  def new() do
    []
  end

  def add(list, language) do
    [language | list]
  end

  def remove([_ | tail]) do
    tail
  end

  def first([head | _]) do
    head
  end

  def count(list) do
    Enum.count(list)
  end

  def functional_list?(list) do
    Enum.find(list, nil, fn e -> e == "Elixir" end) != nil
  end
end
