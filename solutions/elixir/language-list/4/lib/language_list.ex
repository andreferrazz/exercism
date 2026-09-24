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

  def count(list), do: count(list, 0)
  defp count([], acc), do: acc
  defp count([_], acc), do: acc + 1
  defp count([_ | tail], acc), do: count(tail, acc + 1)

  def functional_list?(["Elixir"]), do: true
  def functional_list?(["Elixir" | _]), do: true
  def functional_list?([]), do: false
  def functional_list?([_]), do: false
  def functional_list?([_ | tail]), do: functional_list?(tail)
end
