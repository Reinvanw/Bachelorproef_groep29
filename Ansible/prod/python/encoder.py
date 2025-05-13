import crypt
import sys
import os

def encode_password(password):
    encoded_password = crypt.crypt(password, '$9$' + str(os.urandom(8).hex()))
    return encoded_password

if __name__ == "__main__":
    password = sys.argv[1]
    print(encode_password(password))

