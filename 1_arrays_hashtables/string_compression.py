def compress(string):
    count_array = []
    element_count = 1
    for index, character in enumerate(string[1:]):
        print(character, string[index])
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
    print(count_array)
    for numbers in count_array:
        if(numbers != 1):
            compressed_string += str(numbers)
        compressed_string += string[string_position]
        string_position += numbers
    return compressed_string

if __name__ == '__main__':
    print(compress('aafbbcdaaaaa'))
