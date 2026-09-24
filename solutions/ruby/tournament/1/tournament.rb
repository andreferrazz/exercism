=begin
Write your code for the 'Tournament' exercise in this file. Make the tests in
`tournament_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/tournament` directory.
=end
module Tournament
  module_function
  
  def tally(input)
    table_header = "Team                           | MP |  W |  D |  L |  P\n"
    
    return input
      .lines
      .map {|match_result| match_result.strip}
      .filter {|match_result| !match_result.empty?}
      .inject([]) {|standings, match_result| update_standings(standings, match_result)}
      .sort {|team_a, team_b| compare_results(team_a, team_b)}
      .inject(table_header) {|table, team| render_team_status(table, team)}
  end

  def update_standings(standings, match_result)
    team_a_name, team_b_name, result = match_result.split(';')
    
    team_a = get_team(standings, team_a_name)
    team_b = get_team(standings, team_b_name)

    case result
    when 'win'
      register_victory(winner: team_a, loser: team_b)
    when 'loss'
      register_victory(winner: team_b, loser: team_a)
    when 'draw'
      register_tie(team_a, team_b)
    end

    return standings
  end

  def register_victory(winner:, loser:)
    winner[:mp] = winner[:mp] + 1
    winner[:w] = winner[:w] + 1
    winner[:p] = winner[:p] + 3
    loser[:mp] = loser[:mp] + 1
    loser[:l] = loser[:l] + 1
  end

  def register_tie(team_a, team_b)
    team_a[:mp] = team_a[:mp] + 1
    team_b[:mp] = team_b[:mp] + 1
    team_a[:d] = team_a[:d] + 1
    team_b[:d] = team_b[:d] + 1
    team_a[:p] = team_a[:p] + 1
    team_b[:p] = team_b[:p] + 1
  end

  def get_team(standings, name)
    standing = standings.filter { |team| team[:name] == name }.first
    if (standing == nil) then
      standing = { name: name, mp: 0, w: 0, d: 0, l: 0, p: 0 }
      standings.push(standing)
    end
    return standing
  end

  def render_team_status(table, team)
    table
      .concat(team[:name].ljust(30, " "))
      .concat(" | ")
      .concat(team[:mp].to_s.rjust(2, " "))
      .concat(" | ")
      .concat(team[:w].to_s.rjust(2, " "))
      .concat(" | ")
      .concat(team[:d].to_s.rjust(2, " "))
      .concat(" | ")
      .concat(team[:l].to_s.rjust(2, " "))
      .concat(" | ")
      .concat(team[:p].to_s.rjust(2, " "))
      .concat("\n")
  end

  def compare_results(team_a, team_b)
    if (team_a[:p] <=> team_b[:p]) == 0
      team_a[:name] <=> team_b[:name]
    else
      team_b[:p] <=> team_a[:p]
    end
  end
end