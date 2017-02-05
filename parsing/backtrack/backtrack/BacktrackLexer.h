#ifndef _BACKTRACK_LEXER
#define _BACKTRACK_LEXER
#include <iostream>
#include <string>
namespace t {
	struct Token {
		int type;
		std::string& value;
		Token(int ty,std::string& val):type(ty),value(val){}
		const std::string& toString();
	};
	class BacktrackLexer {
	public:
		static const int EOF_TYPE = 1;
		static const int NAME = 2;
		static const int LBRACK = 3;
		static const int RBRACK = 4;
		static const int COMMA = 5;
		static const int EQUALS = 6;
		
		static std::string tokenNames[];

		BacktrackLexer(std::string& in) :input(in) {

		}

		void match(int i);

		void consume();
	private:
		std::string& input;
		size_t p;
	};
}
#endif // !_BACKTRACK_LEXER