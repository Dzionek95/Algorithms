def compress(string):
    '''
    Returns for abbcdde a2bc2de, not like in exercise 1a2b1c2e1e\n
    If you want to change it, uncomment line 16 and 17 and
    remove condition from line 22
    Max additional O(n) space\n
    Overall O(n) runtime, described in comments\n
    '''

    #max additional O(n) space (usually less, depends on char series)
    count_array = []
    element_count = 1
    # O(n-1)
    for index, character in enumerate(string[1:]):
        if string[index] == character:
            element_count = element_count + 1
        else:
            count_array.append(element_count)
            element_count = 1
    count_array.append(element_count)
    # if len(count_array) == len(string):
    #     return string
    compressed_string = ''
    string_position = 0
    #O(n) maximally, usually the same as additional space
    for numbers in count_array:
        if(numbers != 1):
            compressed_string += str(numbers)
        compressed_string += string[string_position]
        string_position += numbers
    return compressed_string

if __name__ == '__main__':
    print(compress('aafbbcdaaaaa'))
