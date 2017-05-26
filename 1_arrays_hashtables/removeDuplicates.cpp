#include <iostream>
#include <string>

//removeDuplicates declaration 
std::string removeDuplicates(std::string word);

int main(){
 
std::string word;
std::cin >> word;

std::cout << "Given string: " << word << std::endl;

//check if string exists 
if(word.size() == 0){
std::cout << "Empty string!" << std::endl;
return 1;
}

std::cout << "Duplicates removed: " << removeDuplicates(word) << std::endl;
}


//removeDuplicates definition
std::string removeDuplicates(std::string word){
    
    for(std::string::size_type x = 0; x < word.size(); ++x){
        for(std::string::size_type y = x+1; y < word.size();){
   
            //erase forward occurence if exists
            if(word[x] == word[y]){
	    word.erase(y, 1);
            }
            
            //to avoid skipping letters if string size has changed	
            else{
	    y++;
            }
	
        } //y loop
   
    } //x loop
 
return word;
}
