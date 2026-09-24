class LogLineParser
  def initialize(line)
    @line = line
  end

  def message
    @line
      .gsub(/\[[A-Z]+\]:\s/, '')
      .strip
  end

  def log_level
    return @line
      .scan(/[\[][A-Z]+[\]]/)[0]
      .slice(1..-2)
      .downcase
  end

  def reformat
     "#{message} (#{log_level})"
  end
end
