#include<iostream>
#include<unordered_map>

bool is_permutation(const std::string& first, const std::string& second){
  //If length isn't equal they cannot be permutations
  if(first.size() != second.size())
    return false;

  //counter assigned to each character
  std::unordered_map<char, std::size_t> map{};
  //O(n) for copying/updating
  //Space complexity - O(n)
  for(std::size_t i=0; i<first.size(); ++i)
    map[first[i]] = ++map[first[i]];

  //O(n) for going through string
  for(std::size_t i=0; i<second.size(); ++i){
    auto searched_char = map.find(second[i]);
    if(searched_char == map.end() || searched_char->second == 0)
      return false;
    searched_char->second = searched_char->second - 1;
  }

  return true;
}

int main(){
  std::cout << is_permutation("abcd", "acab") << std::endl;
  std::cout << is_permutation("abcd", "dcab") << std::endl;
  //Possible testing - generating random strings with labels true/false

  return 0;
}
